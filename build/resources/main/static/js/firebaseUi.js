// Initialize the FirebaseUI Widget using Firebase.
var ui = new firebaseui.auth.AuthUI(firebase.auth());
var url = location.protocol + "//" + location.host + "/main"
console.log(url + "/main")

    var uiConfig = {
    		  callbacks: {
    		    signInSuccessWithAuthResult: function(authResult, redirectUrl) {
    		      // User successfully signed in.
    		      // Return type determines whether we continue the redirect automatically
    		      // or whether we leave that to developer to handle.
    		      return true;
    		    },
    		    uiShown: function() {
    		      // The widget is rendered.
    		      // Hide the loader.
    		      document.getElementById('loader').style.display = 'none';
    		    }
    		  },
    		  // Will use popup for IDP Providers sign-in flow instead of the default, redirect.
    		  signInFlow: 'popup',
    		  signInSuccessUrl: url,
    		  signInOptions: [
    		    // Leave the lines as is for the providers you want to offer your users.
    		    firebase.auth.GoogleAuthProvider.PROVIDER_ID,
    		    firebase.auth.EmailAuthProvider.PROVIDER_ID,
    		  ],
    		  // Terms of service url.
    		  tosUrl: url,
    		  // Privacy policy url.
    		  privacyPolicyUrl: url
    		};

    	ui.start('#firebaseui-auth-container', uiConfig);

    	firebase.auth().onAuthStateChanged((user) => {
          if (user) {
            // User is signed in, see docs for a list of available properties
            // https://firebase.google.com/docs/reference/js/firebase.User
            var uid = user.uid;

            console.log("ログインしてます。")
            console.log(uid)
            console.log(user.displayName)
            // ...
          } else {
            // User is signed out
            // ...
          }
        });