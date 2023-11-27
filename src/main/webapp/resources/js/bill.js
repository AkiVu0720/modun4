$(document).ready(function () {
    $("#modal-submit").click(function (){
        window.location ="http://localhost:8080/bill/initCreate"
    })
    $("#direction").change(function (){
        let direction = $("#direction").val()
        window.location="http://localhost:8080/bill/findBill?direction="+direction
    })

    $("#sortBy").change(function (){
        let sortBy = $("#sortBy").val();
        window.location="http://localhost:8080/bill/findBill?sortBy="+sortBy
    })
    $("#modal-create").click(function (){
        window.location ="http://localhost:8080/bill/initCreate"
    })
    $("#modal-close").click(function (){
        window.location ="http://localhost:8080/bill/findBill"
    })
    let  dataBillStatus = $("#billStatusEdit").val();
    let  billStatusElement = $("#billStatusEdit")
    console.log(billStatusElement)
    switch (dataBillStatus){
        case 1:
            billStatusElement.innerHTML=`
            <option value="2">Chờ</option>
            <option value="3">Duyệt</option>
            `
    }
})