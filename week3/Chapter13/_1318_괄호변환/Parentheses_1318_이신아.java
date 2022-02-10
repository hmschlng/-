package Chapter13;

public class Parentheses_1318 {

	// "균형잡힌 괄호 문자열"의 인덱스 반환
    public static int balancedIndex(String str) {
        int count = 0; 			// 왼쪽 괄호의 개수
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') 
            	count += 1;
            else 
            	count -= 1;
            if (count == 0) 
            	return i;
        }
        return -1;
    }

    // "올바른 괄호 문자열"인지 판단
    public static boolean checkProper(String str) {
        int count = 0; 			// 왼쪽 괄호의 개수
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') 
            	count += 1;
            else {
                if (count == 0) { // 쌍이 맞지 않는 경우에 false 반환
                    return false;
                }
                count -= 1;
            }
        }
        return true; // 쌍이 맞는 경우에 true 반환
    }
    
    public static String solution(String str) {
        String answer = "";
        if (str.equals("")) 
        	return answer;
        int index = balancedIndex(str);
        String u = str.substring(0, index + 1);
        String v = str.substring(index + 1);
        // "올바른 괄호 문자열"이면, v에 대해 함수를 수행한 결과를 붙여 반환
        if (checkProper(u)) {
            answer = u + solution(v);
        }
        // "올바른 괄호 문자열"이 아니라면 아래의 과정을 수행
        else {
            answer = "(";
            answer += solution(v);
            answer += ")";
            // 첫 번째와 마지막 문자를 제거
            u = u.substring(1, u.length() - 1); 
            String temp = "";
            // 괄호 방향 뒤집기
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') 
                	temp += ")";
                else 
                	temp += "(";
            }
            answer += temp;
        }
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "(()())()";
		String str2 = ")(";
		String str3 = "()))((()";
		System.out.println(solution(str1));
		System.out.println(solution(str2));
		System.out.println(solution(str3));
	}

}
