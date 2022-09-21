import java.util.*;

public class ACMcraft {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int constructure;
        int ruleCount;
        int constructureTime;
        int startRule;
        int endRule;
        int destCons;

        int[] indegree;
        int[] accuConstTime;

        for(int i = 0; i<testCase; i++) {
            List<Integer> timeList = new ArrayList<>();
            List<ConsRule> consRules = new ArrayList<>();
            List<Integer> minTimeList = new ArrayList<>();
            Queue<Integer> route = new LinkedList<>();
            List<List<Integer>> list= new ArrayList<>();
            constructure = sc.nextInt();
            ruleCount = sc.nextInt();
            indegree = new int[constructure+1];
            accuConstTime = new int[constructure+1];

            for(int a = 0; a<accuConstTime.length; a++) {
                accuConstTime[a] = 0;
            }

            for(int j=0; j<constructure; j++) {
                constructureTime = sc.nextInt();
                timeList.add(constructureTime);
                minTimeList.add(0);
                list.add(new ArrayList<>());
            }
            list.add(new ArrayList<>());

            for(int k = 0; k < ruleCount; k++) {
                ConsRule consRule = new ConsRule();
                startRule = sc.nextInt();
                endRule = sc.nextInt();
                consRule.setStart(startRule);
                consRule.setEnd(endRule);
                consRules.add(consRule);

            }

            destCons = sc.nextInt();
            // 입력

            for(int l=1; l<ruleCount+1; l++) {
                int v1 = consRules.get(l-1).getStart();
                int v2 = consRules.get(l-1).getEnd();

                list.get(v1).add(v2);
                indegree[v2]++;

            }

            route = topologicalSort(indegree, list);

            for(int c = 1; c < indegree.length; c++) {
                if(indegree[c] == 0) {
                    accuConstTime[c] = timeList.get(c-1);
                }
            }

            while(!route.isEmpty()) {
                int poll = route.poll();
                int tempaccuTime = accuConstTime[poll];
                for(int a = 0; a < list.get(poll).size(); a++) {
                    int tempTime = timeList.get(list.get(poll).get(a)-1) + tempaccuTime;
                    if(tempTime > accuConstTime[list.get(poll).get(a)]) {
                        accuConstTime[list.get(poll).get(a)] = tempTime;
                    }
                }

            }

            System.out.println(accuConstTime[destCons]);

        }
    }

    static Queue<Integer> topologicalSort(int[] indegree, List<List<Integer>> array) {
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> result = new LinkedList<Integer>();

        // 큐에 indegree 가 0 인 노드 담기
        for (int i = 1; i < array.size(); i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        /**
         * 1. 큐에서 값을 꺼내며 해당 노드가 가리키는 노드의 indegree 를 1 감소
         * 2. 만약 indegree가 0 이 된다면 큐에 넣기
         * 3. 큐가 빌때까지 반복
         */
        while (!q.isEmpty()) {
            int node = q.poll();
            result.offer(node);

            for (Integer i : array.get(node)) {
                indegree[i]--;

                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        return result;
    }
}

class ConsRule {
    private int start;

    private int end;

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }


    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

}
