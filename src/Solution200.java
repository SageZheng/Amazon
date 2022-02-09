public class Solution200 {
    public int numIslands(char[][] grid) {
        boolean[][] gridNon = new boolean[grid.length][grid[0].length];
        int num=0;
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!gridNon[i][j]&&grid[i][j]=='1')
                {
                    num+=1;
                    DFS(gridNon,grid,i,j);
                }
            }
        }
        return num;
    }
    public void DFS(boolean[][] gridNon,char[][] grid,int row,int list){
        if(row>0&&!gridNon[row-1][list]&&grid[row-1][list]=='1')
        {
            gridNon[row-1][list]=true;
            DFS(gridNon,grid,row-1,list);
        }
        if(row< grid.length-1&&!gridNon[row+1][list]&&grid[row+1][list]=='1')
        {
            gridNon[row+1][list]=true;
            DFS(gridNon,grid,row+1,list);
        }
        if(list>0&&!gridNon[row][list-1]&&grid[row][list-1]=='1'){
            gridNon[row][list-1]=true;
            DFS(gridNon,grid,row,list-1);
        }
        if(list<grid[0].length-1&&!gridNon[row][list+1]&&grid[row][list+1]=='1'){
            gridNon[row][list+1]=true;
            DFS(gridNon,grid,row,list+1);
        }
    }
}
