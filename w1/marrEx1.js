const arr = [
    [{month:1, total: 90},{month:2, total: 87},{month:3, total: 140}],
    [{month:4, total: 130},{month:5, total: 130},{month:6, total: 150}],
    [{month:7, total: 180},{month:8, total: 240},{month:9, total: 200}],
    [{month:10, total: 180},{month:11, total: 140},{month:12, total: 190}]
]

const parr = []
//가장 매출이 좋았던 분기
//각 분기별로 매출 평균을 만든다


for (let i = 0; i<arr.length; i++){
    const tempArr = arr[i]
    console.log(tempArr)

    let sum = 0
    for (let j = 0; j < tempArr.length; j++) {
        sum += tempArr[j].total
    }
    const tempAvg = (sum/tempArr.length).toFixed(2)
    console.log(tempAvg)
    parr.push(parseFloat(tempAvg)) //parseFloat 쓰는 이유는?
}

console.log(parr)




//그 중에서 최대 평균을 찾는다
// 분기별 평균 , 평균의 최댓값

//최고 매출 금액 찾기
let max = 0
let period  = 0
for (let i = 0; i < parr.length ; i++) {
    if(parr[i]>max){
        max = parr[i]
        period = [i]    
    }

}

console.log("Max: "+max)
console.log("Period: " + (parseInt(period)+1) +"분기입니다.")

// 최대 매출월?
let maxM = 0
let periodM = 0
for (let i = 0; i < arr[period].length; i++) {
    const parr= arr[period][i]
    console.log(parr)
    for (let j = 0; j <parr.length; j++) {
        if (parr[j].total>maxM){
            maxM=parr[j].total

    }
    }
}


console.log((parseInt(period)+1)+"분기 최대 매출액: "+maxM)
console.log((parseInt(period)+1)+"분기 최대 매출의 달은" +(parseInt(periodM)+1)+"월 입니다.")