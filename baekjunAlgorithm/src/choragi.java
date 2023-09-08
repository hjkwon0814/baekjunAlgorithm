import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class choragi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        int area = sc.nextInt();
        int armyCount = sc.nextInt();
        int answer = 0;
        List<AreaInfo> areaInfoList = new ArrayList<AreaInfo>();
        while(sc.hasNextInt()) {
        	AreaInfo areaInfo = new AreaInfo();
        	areaInfo.setEnemyCount(sc.nextInt());
        	if(areaInfoList.size() / area == 0) {
        		areaInfo.setLine(1);
        	}else {
        		areaInfo.setLine(2);
        	}     	
        	areaInfoList.add(areaInfo);
        }
        
        for(int j = 0; j<testcase; j++) {
        	for(int i = 0; i <= (area*2)-1; i++) {
        		int sideNum = ((i + 1) % area) == 0 ? (i+1) - area : (i + 1);
            	if(areaInfoList.get(i).getLine() == 1) {            		
            		if(!areaInfoList.get(i).getIsChecked() && armyCount >= areaInfoList.get(i).getEnemyCount() + areaInfoList.get(i + area).getEnemyCount()) {
            			areaInfoList.get(i).setIsChecked(true);
            			areaInfoList.get(i+area).setIsChecked(true);
            			answer++; 
            		}
            		
            		if(!areaInfoList.get(i).getIsChecked() && !areaInfoList.get(sideNum).getIsChecked() && armyCount >= areaInfoList.get(i).getEnemyCount() + areaInfoList.get(sideNum).getEnemyCount()) {
            			areaInfoList.get(i).setIsChecked(true);
            			areaInfoList.get(sideNum).setIsChecked(true);
            			answer++;
            		}
            	} else {
            		if(!areaInfoList.get(i).getIsChecked() && !areaInfoList.get(sideNum).getIsChecked() && armyCount >= areaInfoList.get(i).getEnemyCount() + areaInfoList.get(sideNum).getEnemyCount()) {
            			areaInfoList.get(i).setIsChecked(true);
            			areaInfoList.get(sideNum).setIsChecked(true);
            			answer++;
            		}
            	}
            }
        	
        	answer = ((area - answer) * 2) + answer;
        	System.out.println(answer);
        	
        }
        
        
        
        

    }

}

class AreaInfo {
	
	private boolean isChecked = false;
	
	private int enemyCount;
	
	private int line;
	
	public void setIsChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
	public void setEnemyCount(int enemyCount) {
		this.enemyCount = enemyCount;
	}
	
	public void setLine(int line) {
		this.line = line;
	}
	
	public boolean getIsChecked() {
		return this.isChecked;
	}
	
	public int getEnemyCount() {
		return this.enemyCount;
	}
	
	public int getLine() {
		return this.line;
	}
}