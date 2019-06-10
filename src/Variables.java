public class Variables {
    //map variables
    int MAPSIZE = 3;
    String[][] map = createMap(MAPSIZE);//{{"0","0","0"}{"0","0","0"}{"0","0","0"}}
    //player variables
    int playerX = 1;
    int playerY = 1;
    int previousPlaX = 0;
    int previousPlaY = 0;
    boolean alive = true;

    public String[][] createMap(int size){
        //populate the row guide
        String[][] returner = new String[size][size];
        for(int i = 0; i < size; i++){
            for(int ii = 0; ii < size; ii++){
                returner[i][ii] = "0";
            }
        }
        //populate the columbs
        //return a full double array of the starting ground
        return returner;
    }

    //getters
    public int getMAPSIZE(){
        return MAPSIZE;
    }

    public int getplayerX(){
        return playerX;
    }

    public int getplayerY(){
        return playerY;
    }

    public int getpreviousPlaX(){
        return previousPlaX;
    }

    public int getpreviousPlaY(){
        return previousPlaY;
    }

    public String getmap(int x, int y){
        return map[y][x];
    }

    public boolean getalive(){
        return alive;
    }

    //setters
    public void setplayerX(int xValue){
        playerX = xValue;
    }

    public void setplayerY(int yValue){
        playerY = yValue;
    }

    public void setpreviousPlaX(int xValue){
        previousPlaX = xValue;
    }

    public void setpreviousPlaY(int yValue){
        previousPlaY = yValue;
    }

    public void setmap(int x, int y, String newValue){
        map[y][x] = newValue;
    }

    public void setalive(boolean answer){
        alive = answer;
    }
}