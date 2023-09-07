import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class choragi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        int area = sc.nextInt();
        int armyCount = sc.nextInt();
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
        
        for(int i = 1; i <= area*2; i++) {
        	if(i % area == 1 && areaInfoList.get(i-1).getLine() == 0) {
        		List<Integer> checkList = new ArrayList<Integer>();
        		checkList.add(i+1);
        		checkList.add(i+8);
        		checkList.add(i+area-1);
        		for(Integer index : checkList) {
        			if(!areaInfoList.get(i).getIsChecked()) {
    					break;
    				}
        			if(armyCount >= areaInfoList.get(i).getEnemyCount() + areaInfoList.get(index).getEnemyCount()) {
        				areaInfoList.get(i).setIsChecked(true);
        				areaInfoList.get(index).setIsChecked(true);
        			}
        		}
        	} else if (i % area == 0 && areaInfoList.get(i-1).getLine() == 0) {
        		List<Integer> checkList = new ArrayList<Integer>();
        		checkList.add(i-1);
        		checkList.add(i+8);
        		checkList.add(i-area+1);
        	} else if(i % area == 1 && areaInfoList.get(i-1).getLine() == 1){
        		List<Integer> checkList = new ArrayList<Integer>();
        		checkList.add(i+1);
        		checkList.add(i+area-1);
        	} else if(i % area == 0 && areaInfoList.get(i-1).getLine() == 1) {
        		List<Integer> checkList = new ArrayList<Integer>();
        		checkList.add(i-1);
        		checkList.add(i-area+1);
        	} else {
        		
        	}
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