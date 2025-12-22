public class Subject {
    private String subjectId;
    private String subjectName;
    private Array<String> subjects;
    public Subject(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }
    public String getSubjectId(){
        return subjectId;
    }
    public Subject(int size) {
        subjects = new Array<>(size);
    }

    public boolean addSubject(String name) {
        return subjects.append(name);
    }

    public boolean insertSubject(String name, int pos) {
        return subjects.insert(name, pos);
    }

    public boolean deleteSubject(String name) {
        for (int i = 0; i < subjects.getCount(); i++) {
            if (subjects.search(name) == i) {
                if (subjects.deleteByPosition(i)) {
                    System.out.println("The subject deleted successfully");
                    return subjects.deleteByPosition(i);
                } else {
                    System.out.println("There is no subject to delete.");
                }
            }
        }
        return false;
    }

    public boolean updateSubject(String oldName, String newName) {
        for (int i = 0; i < subjects.getCount(); i++) {
            if (subjects.search(oldName) == i) {
                subjects.deleteByPosition(i);
                subjects.insert(newName, i);
                return true;
            }
        }
        return false;
    }

    public boolean searchSubject(String name) {
        return (subjects.search(name) != -1);
    }

    public void traverse() {
        subjects.traverse();
    }
}
