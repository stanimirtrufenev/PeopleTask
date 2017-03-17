// global. currently active menu item 
var current_item = 0;

// few settings
var section_hide_time = 1300;
var section_show_time = 1300;
var flag = 0;

// jQuery stuff
jQuery(document).ready(function($) {
	$( "#names15" ).fadeOut( "slow", function() {
	    // Animation complete.
});
	hideLoginError();
	hideRegisterError();
	hideEmptyLengthError();
	hideMinLengthError();
	hideEmptyError();
	hideEmailError();
	hidePinError();
	// Switch section
	$("a", '.mainmenu').click(function() 
	{
		$( "#names15" ).fadeOut( "slow", function() {
		    // Animation complete.
	});
		hideLoginError();
		hideRegisterError();
		hideEmptyLengthError();
		hideMinLengthError();
		hideEmptyError();
	    hideEmailError();
	    hidePinError();
		if( ! $(this).hasClass('active') ) { 
			current_item = this;
			// close all visible divs with the class of .section
			$('.section:visible').fadeOut( section_hide_time, function() { 
				$('a', '.mainmenu').removeClass( 'active' );  
				$(current_item).addClass( 'active' );
				var new_section = $( $(current_item).attr('href') );
				new_section.fadeIn( section_show_time );
			} );
		}
		return false;
	});
	
	
});

function showRegisterError() {
	

		$( "#names1" ).fadeOut( "slow", function() {
			$( "#names" ).fadeOut( "slow", function() {
				$( "#test_me" ).fadeIn( "slow", function() {
					
			  });
		  });
	  });
}

function showLoginError() {
	
	$( "#test_me1" ).fadeIn( "slow", function() {
	    // Animation complete.
	  });
}

function hideLoginError() {
	$( "#test_me1" ).fadeOut( "slow", function() {
	    // Animation complete.
	  });
}
function hideRegisterError() {
	$( "#test_me" ).fadeOut( "slow", function() {
	    // Animation complete.
	  });
}

function showMinLengthError() {
	
		$( "#test_me" ).fadeOut( "slow", function() {
			$( "#names1" ).fadeOut( "slow", function() {
				$( "#names" ).fadeIn( "slow", function() {
				    // Animation complete.
				  });
			  });
		  });
	

}
function hideMinLengthError() {
	$( "#names" ).fadeOut( "slow", function() {
	    // Animation complete.
	  });
}
function showEmptyLengthError() {
	$( "#names" ).fadeIn( "slow", function() {
			    // Animation complete.
	  });

}
function hideEmptyLengthError() {
	$( "#names" ).fadeOut( "slow", function() {
	    // Animation complete.
	  });
}

function showPinError() {
	$( "#names2" ).fadeIn( "slow", function() {
			    // Animation complete.
	  });

}

function hidePinError() {
	$( "#names2" ).fadeOut( "slow", function() {
	    // Animation complete.
	  });
}

function showEmailError() {
	$( "#names4" ).fadeIn( "slow", function() {
			    // Animation complete.
	  });

}
function hideEmailError() {
	$( "#names4" ).fadeOut( "slow", function() {
	    // Animation complete.
	  });
}

function showEmptyError() {
	$( "#names3" ).fadeIn( "slow", function() {
			    // Animation complete.
	  });

}

function hideEmptyError() {
	$( "#names3" ).fadeOut( "slow", function() {
	    // Animation complete.
	  });
}


function submitSearch() {
	$( "#names15" ).fadeOut( "slow", function() {
	    // Animation complete.
});
	var loginName = document.getElementById("searchName").value;
	
	
	if(loginName.length > 0){
	jQuery.ajax({
	    type: 'POST',
	    url: "SearchPerson?name=" + loginName,
	    //contentType: 'application/json',//{ name: "John", location: "Boston" },
	    success:  function(data) {
	    	if (data.indexOf("error") >= 0) {
	    		showLoginError();
	    	} else {
		    	window.location.href = data;
	    	}

	    }
	});
	}else{
		$( "#names15" ).fadeIn( "slow", function() {
		    // Animation complete.
  });
	}
}

function submitCreate() {
	hideLoginError();
	hideRegisterError();
	hideEmptyLengthError();
	hideMinLengthError();
	hideEmptyError();
    hideEmailError();
    hidePinError();
	var fullName = document.getElementById("fullName").value;
	var pin = document.getElementById("pin").value;
	var addressType = document.getElementById("addressType").value;
	var addressInfo = document.getElementById("addressInfo").value;
	var emailType = document.getElementById("emailType").value;
	var email = document.getElementById("email").value;
	
	var regex = /^[a-zA-Z -]{3,20}$/;
	if (!regex.test(fullName)){
	showEmptyLengthError();
		return;
	}
	
	var regex1 = /^[0-9]{10}$/;
	if (!regex1.test(pin)){
	showPinError();
		return;
	}
	
	var regex2 = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
	if(email.length != 0){
	 if (!regex2.test(email)){
	 showEmailError();
		 return;
	 }
	}
	
	if(addressType.length == 0 || emailType.length == 0) {
		showEmptyError();
		return;
	}
	
	
	//var myJSON  = {firstName:"true", password: "Boston", lastName:"peio", username: "John"}; 
	var myJSON  = {fullName: ""+fullName+"", pin: ""+pin+"",addressType:""+addressType+"", addressInfo: "" + addressInfo + "",emailType:""+emailType+"",email:""+email+""}; 
	alert(JSON.stringify(myJSON));
	myJSON = JSON.stringify(myJSON);
	jQuery.ajax({
	    type: 'POST',
	    url: '/MyProject/create?name=' + fullName + '&pin=' + pin + '&addressType=' + addressType + '&addressInfo=' + addressInfo + '&emailType=' + emailType + '&email=' + email,
	    //data:myJSON,
	    
	    //contentType: 'application/json',//{ name: "John", location: "Boston" },
	    success:  function(data) {
//	    	alert("OK");
	    	if (data.indexOf("error") >= 0) {
	    		showRegisterError();
	    	} else {
		    	window.location.href = data;
	    	}
	    },
	    error: function(jqXHR, exception){
	    	console.log(jqXHR.responseText);
	    }
	});
}