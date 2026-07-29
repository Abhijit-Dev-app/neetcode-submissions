
class Solution {

    class DSU {
        Map<String, String> parent = new HashMap<>();

        public String find(String s) {
            if (!parent.get(s).equals(s)) {
                parent.put(s, find(parent.get(s)));
            }
            return parent.get(s);
        }

        public void union(String a, String b) {
            String pa = find(a);
            String pb = find(b);
            if (!pa.equals(pb)) {
                parent.put(pa, pb);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap<>();

        // Initialize parent and email->name map
        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                parentInit(dsu, email);
                emailToName.put(email, name);
            }
        }

        // Union emails within the same account
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);

            for (int i = 2; i < account.size(); i++) {
                dsu.union(firstEmail, account.get(i));
            }
        }

        // Group emails by parent
        Map<String, List<String>> groups = new HashMap<>();

        for (String email : emailToName.keySet()) {
            String root = dsu.find(email);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        // Build answer
        List<List<String>> result = new ArrayList<>();

        for (String root : groups.keySet()) {
            List<String> emails = groups.get(root);
            Collections.sort(emails);

            List<String> merged = new ArrayList<>();
            merged.add(emailToName.get(root));
            merged.addAll(emails);

            result.add(merged);
        }

        return result;
    }

    private void parentInit(DSU dsu, String email) {
        dsu.parent.putIfAbsent(email, email);
    }
}