package com.sugar.boilerplate.Network.Utils;


public interface Constants {

    // sharedpreferene

    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    String token="123";
    int api_name=1;
    String imagePath="https://travelhope.org/uploads/ota/8ed24880-e6ad-11e8-a4c9-15f8a84bf814/supplier/ce117c90-fe24-11e8-9279-3365dce12a2f/main/";



    String kStringNetworkConnectivityError = "Please make sure your device is connected with internet.";
    String EXCEPTION = "Exception";
    String EXCEPTION_MESSAGE = "Something went wrong";
    String SERVER_EXCEPTION_MESSAGE = "Something went wrong, server not responding";



    String mPARAMETERS = "id,name,email,gender,birthday,picture.type(large),cover,age_range";

    // Snappy save User data
    String USER_DATA = "userData";

    // Snappy save my stories data
    String STORY_DATA = "myStoriesData";

    // Preferences
    String PREF_IS_USER_LOGIN = "isUserLogIn";

    //Constants Extras
    String USER_NMAE = "name";
    String USER_EMAIL = "email";
    String USER_GENDER = "gender";
    String USER_ID = "id";
    String USER_AUTH_METHOD = "authMethod";
    String USER_ACCESS_TOKEN = "accessToken";
}
