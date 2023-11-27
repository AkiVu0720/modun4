$(document).ready(function () {
    $("#modal-submit").click(function (){
        window.location ="http://localhost:8080/userManage/initCreate"
    })
    $("#direction").change(function (){
        let direction = $("#direction").val()
        window.location="http://localhost:8080/userManage/findUser?direction="+direction
    })

    $("#sortBy").change(function (){
        let sortBy = $("#sortBy").val();
        window.location="http://localhost:8080/userManage/findUser?sortBy="+sortBy
    })
    $("#modal-create").click(function (){
        window.location ="http://localhost:8080/userManage/initCreate"
    })
    $("#modal-close").click(function (){
        window.location ="http://localhost:8080/userManage/findUser"
    })
})