class Solution {
    public List<String> all = new ArrayList<>();

    public boolean valid(StringBuilder sb) {
        int n = sb.length() - 1;

        int num = 0;
        int p = 1;
        while (n >= 0 && sb.charAt(n) != '.') {
            num += (sb.charAt(n) - '0') * p;
            p *= 10;
            n--;
        }

        return (num <= 255 && Math.log10(p) <= Math.log10(num) + 1) || (num == 0 && p == 10);
    }

    public void generate(int i, String s, StringBuilder sb, int n, int dots) {
        if (dots > 3) return;

        if (i >= n) {
            if (dots == 3 && sb.charAt(sb.length() - 1) != '.') all.add(sb.toString());
            return;
        }

        sb.append(s.charAt(i));
        if (!valid(sb)) {
            sb.setLength(sb.length() - 1);
            return;
        }

        generate(i + 1, s, sb, n, dots);

        sb.append('.');

        generate(i + 1, s, sb, n, dots + 1);
        sb.setLength(sb.length() - 1);

        sb.setLength(sb.length() - 1);
    }

    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder();
        generate(0, s, sb, s.length(), 0);

        return all;
    }
}
