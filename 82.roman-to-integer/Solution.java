class Solution {
    public int romanToInt(String s) {
        int[] data = new int[s.length()];
        HashMap<Character,Integer> map= new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        if(s.length()==1)return map.get(s.charAt(0));
        for(int i=0;i<s.length();i++){
            data[i]=map.get(s.charAt(i));
        }
        int i=0,j=1;
        int ans=0;
        while(i<s.length()){
            if(j==s.length()){
                ans+=map.get(s.charAt(i));
                i++;
            }
            else if(data[i]<data[j]){
                ans+=(data[j]-data[i]);
                i+=2;j+=2;
            }else{
                ans+=data[i];
                i++;j++;
            }
        }
        
        
     return ans;   
    }
}