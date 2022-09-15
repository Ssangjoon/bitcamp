function calcTotal(hourValue,minValue){    // 파라미터에 이름이 달라도 입력이 되나?
    // 시침 각도 구하는 함수 --> 입력 시 12  출력 각도
    function calcHour(hour){

        const result = (360/12)*(hour%12)
        return result
    }// 함수의 선언문

//분침 각도 구하는 함수 , 화살표 함수
    const calcMin = (min) => (360/60)*min   //화살표함수 쓰면 함수와 같이 사용 가능한가?
    //     function calcMin(min) {
//         const result =(360/60)*min
//
//     return result

// const calcMin = (min) => {
// return (360/60)*min
// }

//분침 이동에 따른 시침의 이동각도 구하는 함수
    function getExtra(min){
        return((360/12)/60)*min
    }
    const result =  Math.abs((calcHour(hourValue)+ getExtra(minValue))-calcMin(minValue))
    return result > 180 ? 360-result:result
}

console.log(calcTotal(12,38))

//12:38