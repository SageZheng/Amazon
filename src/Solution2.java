import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Solution2 {
    public static List<String> implementAPI(List<String> logs) {
        // Write your code here
        HashMap<String, String> Users = new HashMap<>();
        HashMap<String, Boolean> logStatus = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < logs.size(); i++) {
            String[] input = logs.get(i).split(" ", 2);
            //System.out.println(input[1]);
            if (input[0].charAt(0) == 'r') {
                Register(input[1], Users, res,logStatus);
            } else if (input[0].charAt(3) == 'i'){
                //System.out.println(input[1]);
                Login(input[1], Users, res, logStatus);
            }
            else
                Logout(input[1], Users, res, logStatus);
        }
        return res;
    }

    public static void Register(String input, HashMap<String, String> users, List<String> res,HashMap<String, Boolean> logStatus) {
        String[] infor = input.split(" ");
        if (users.get(infor[0]) != null) {
            res.add("Username already exists");
        } else {
            users.put(infor[0], infor[1]);
            logStatus.put(infor[0], false);
            res.add("Registered Successfully");
        }
    }

    public static void Login(String input, HashMap<String, String> users, List<String> res, HashMap<String, Boolean> logStatus) {
        String[] infor = input.split(" ");
       //System.out.println(logStatus.get(infor[0]));
        if (users.get(infor[0]) == null || !Objects.equals(users.get(infor[0]), infor[1])||logStatus.get(infor[0])==null||logStatus.get(infor[0])) {
            res.add("Login Unsuccessful");
        } else {
           // System.out.println("?");
            res.add("Logged In Successfully");
            logStatus.put(infor[0], true);
        }
    }

    public static void Logout(String input, HashMap<String, String> users, List<String> res, HashMap<String, Boolean> logStatus) {
        if (users.get(input) == null||logStatus.get(input)==null||!logStatus.get(input))
            res.add("Logout Unsuccessful");
        else {
            res.add("Logged Out Successfully");
            logStatus.put(input, false);
        }
    }

    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        s.add("register david david123");
        s.add("register adam 1Adam1");
        s.add("login david david123");
        s.add("login adam 1adam1");
        s.add("logout david");
        System.out.println(implementAPI(s));
    }
}
