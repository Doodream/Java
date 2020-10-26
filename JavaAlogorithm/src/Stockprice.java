public class Stockprice {
    public int[] solution(int[] prices) {
        int[] answer = {};
        // answer의 크기는 prices의 크기와 같다.
        answer = new int[prices.length];
        // 가격이 내려가지 않는 시간.
        int count  = 0;
        // prices[0]부터 시작해서 price[prices.length - 1]까지 간다.
        for (int i = 0; i < prices.length; i++) {
            // prices[i]의 비교는 price[i + 1]부터 시작되므로
            for (int j = i + 1; j < prices.length; j++) {
                // prices[i]가 prices[j]보다 작다면 count ++
                if(prices[i] <= prices[j]){
                    count++;
                }
                // prices[i]가 price[j] 보다 크다면 count ++후 종료 ,answer[i+1]차례로 넘어감
                else{
                    count++;
                    break;
                }

            }
            //answer[i]는 count를 넣고
            answer[i] = count;
            //count는 다음 answer[i + 1]를 위해서 초기화.
            count = 0;
        }
        return answer;
    }
}
