import javax.swing.*;
import java.util.Comparator;
import java.util.TreeSet;

class JLabelLengthComparator implements Comparator<JLabel> {
    @Override
    public int compare(JLabel l1, JLabel l2) {
        int len1 = l1.getText().length();
        int len2 = l2.getText().length();
        if (len1 != len2) return Integer.compare(len2, len1); // absteigend
        return l1.getText().compareToIgnoreCase(l2.getText());
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }
}

class JLabelTreeSetTest {
    public static void main(String[] args) {
        JLabel lab1 = new JLabel("kurzer Text");
        JLabel lab2 = new JLabel("KURZER TEXT");
        JLabel lab3 = new JLabel("Ein laaaanger Text");

        TreeSet<JLabel> allLabels = new TreeSet<>(new JLabelLengthComparator());
        allLabels.add(lab1);
        allLabels.add(lab2);
        allLabels.add(lab3);

        for (JLabel l : allLabels) System.out.println(l.getText());
    }
}
