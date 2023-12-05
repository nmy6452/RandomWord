function calorie_count() {
    var ids = [] 
    ids.push(document.getElementById("id1").value);
    ids.push(document.getElementById("id2").value);
    ids.push(document.getElementById("id3").value);
    ids.push(document.getElementById("id4").value);
    ids.push(document.getElementById("id5").value);
    ids.push(document.getElementById("id6").value);
    ids.push(document.getElementById("id7").value);

    console.log(ids);

    document.getElementById("result_1").innerHTML = ids[0];
    document.getElementById("result_2").innerHTML = ids[1];
    document.getElementById("result_3").innerHTML = ids[2];
    document.getElementById("result_4").innerHTML = ids[3];
    document.getElementById("result_5").innerHTML = ids[4];
    document.getElementById("result_6").innerHTML = ids[5];
    document.getElementById("result_7").innerHTML = ids[6];
    var sum = 0;
    for(var id in ids){
        console.log(ids[id]);
        sum += parseInt(ids[id]);
    }
    document.getElementById("result").innerHTML = sum;

}

function alat(){
    console.log("aaaaaaaa")
}