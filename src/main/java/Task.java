public class Task {

        protected String description;
        protected boolean isDone;

        public Task(String description) {
            this.description = description;
        }

        public String getStatusIcon() {
            return (isDone ? "X" : " "); // mark done task with X
        }

        protected void setDone(boolean status) {
            isDone = status;
        }

        protected String getDesc(){
            return description;
        }

        @Override
        public String toString() {
            return description;
        }   // description to print to console output
}
