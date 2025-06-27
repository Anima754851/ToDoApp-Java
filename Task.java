      public class Task {
	    int id;
	    String title;
	    boolean isCompleted;

	    public Task(int id, String title) {
	        this.id = id;
	        this.title = title;
	        this.isCompleted = false;
	    }

	    public String toString() {
	        return id + ". " + title + " [" + (isCompleted ? "✅ Done" : "❌ Not Done") + "]";
	    }
	}

