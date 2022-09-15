const arrayNum = [3,6,10,29,39,20,2,340,382,49]

function getMax(arr){
    let max = 0
    for (let i = 0; i < arr.length; i++) {
        if(arr.length>max)
            max = arr[i]

    }
    return=max
}

console.log(getMax())