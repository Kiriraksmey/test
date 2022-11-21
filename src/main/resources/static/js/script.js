function  requestData(page){
    let name = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    //Validate username and password not null
    if((!name || name.length === 0) || (!password || password.length === 0)){
      document.getElementById("message").innerHTML = "Username and Password not blank";
      return;
    }
    $.ajax({
        type: "POST",
        url: "https://localhost:8088" + page,
        data:JSON.stringify({"userid":name, "password":encodeStrToBase64(password)}),
        contentType:"appilcation/json",
        success: function (result){
            console.log(result);
            if(result == "otp"){
                if (result == "otp"){
                    localStorage.setItem("username",name);
                }
                window.location.href = result;
            }
        },
    });
}
//check otp code
function checkOtpcode(){
    let otp = "";
    let userName = localStorage.getItem("userName");
    let elements = document.getElementsByName("otpCode");
    for(let i= 0; i<elements.length; i++){
        let value = elements[i].value;
        if(!value || value.length == 0){
            return;
        }
        otp = otp +value;
    }
    $.ajax({
        type:"POST",
        headers:{'userName': userName},
        data:JSON.stringify({"userid":userName,"otpCode":otp}),
        url: "https://localhost:8088/otp/checkOtpCode",
        contentType: "application/json",
        success: function (result){
            switch (result){
                case "expired": document.getElementById("message").innerHTML = "Otp expired";
                break;
                case "dashboard": window.location.href = result;
                break;
            }
            return;
        },
    });
}