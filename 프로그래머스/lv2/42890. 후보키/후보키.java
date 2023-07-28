import java.util.*;

class Solution {
    
    String[][] relations;
    List<int[]> subKey;
    int[] check;
    
    public int checkSubKey(){
        int res = subKey.size();
        for(int i=0; i<subKey.size(); i++){
            int[] st = subKey.get(i);
            f: for(int j=0; j<subKey.size(); j++){
                int[] tg = subKey.get(j);
                int st_n =0, tg_n =0;
                for(int n=0; n<check.length; n++){
                    if(st[n]==1&&tg[n]==0){ st_n++; }
                    if(st[n]==0&&tg[n]==1){ tg_n++; }
                }
                if(0<st_n&&tg_n==0){
                    res--;
                    break f;
                }
            }
        }
        return res;
    }
    
    public void dfs(int index){
        if(isSubKey()){
            int[] newSubKey = Arrays.copyOf(check, check.length);
            subKey.add(newSubKey);
            return;
        }
        if(relations[0].length<=index){
            return;
        }
        check[index] = 1;
        dfs(index+1);
        check[index] = 0;
        dfs(index+1);
    }
    
    public boolean isSubKey(){
        Set<String> set = new HashSet<>();
        for(int i=0; i<relations.length; i++){
            StringBuilder builder = new StringBuilder();
            for(int j=0; j<relations[i].length; j++){
                if(check[j]==1){
                    builder.append(relations[i][j]+" ");
                }
            }
            String target = builder.toString();
            if(!set.contains(target)){
                set.add(target);
            }else{
                return false;
            }
        }
        return true;
    }
    
    public int solution(String[][] relation) {
        
        relations = relation;
        subKey = new ArrayList<>();
        check = new int[relation[0].length];
        
        dfs(0);
        return checkSubKey();
    }
    
}