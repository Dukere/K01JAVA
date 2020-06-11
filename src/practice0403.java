class Solution {
    int temp;
    
    public int[] solution(int[] array, int[][] commands) {
    	int[] answer=new int[commands.length];
    	for(int i = 0; i < commands.length; i++){
            int x=0;
            int[] arr = new int[commands[i][1]-commands[i][0]+1];
            for (int j=commands[i][0]-1; j<commands[i][1]; j++){
                arr[x]=array[j];
                x++;
            }
            for(int j =0; j<arr.length-1; j++){
                for(int k = 0; k<arr.length-1-j;k++){
                    if(arr[k]>arr[k+1]){
                        temp = arr[k];
                        arr[k]= arr[k+1];
                        arr[k+1]=temp;
                    }
                }
            }
            for(int z = 0 ; z<arr.length;z++) {
            	System.out.print(arr[z]+ " ");
            }
            System.out.println();
            answer[i]=arr[commands[i][2]-1];
        }
        for(int i = 0 ; i<3;i++) {
        	System.out.println(answer[i]);
        }
        return answer;
    }
}

public class practice0403 {

	public static void main(String[] args) {
		 Solution sl = new Solution();
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		sl.solution(array,commands);
	}

}
