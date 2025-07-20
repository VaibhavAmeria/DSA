class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Set <String> set = new HashSet <>(Arrays.asList(folder));
        List <String> ans = new ArrayList <>();
        for (String currFolder : folder) {
            boolean isSubFolder = false;
            String tempFolder = currFolder;
            while (!tempFolder.isEmpty()) {
                int position = tempFolder.lastIndexOf('/');
                if (position == -1) {
                    break;
                }
                if (set.contains(tempFolder.substring(0, position))) {
                    isSubFolder = true;
                }
                tempFolder = tempFolder.substring(0, position);
            }
            if (!isSubFolder) {
                ans.add(currFolder);
            }
        }
        return ans;
    }
}