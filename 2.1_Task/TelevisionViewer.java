public class TelevisionViewer {
    private final Television television;
    private int dayCount;

    public TelevisionViewer(Television television) {
        this.television = television; 
        this.dayCount = 1;
    }

    public void startWatching(int totalDays) {
        // The user wakes up today and starts watching
        for (int i = 1; i <= totalDays; i++) {
            System.out.println("Woke up, day" + dayCount++);
            // The user starts watching a random amount of channels before falling asleep
            int randomChannelsPerDay = randomNumber(5);
            for (int j = 0; j < randomChannelsPerDay; j++) {
                int channel = television.watchNextChannel();
                System.out.println("Watching channel " + channel);
            }
            System.out.println("Falling asleep");
        }
    }

    public static int randomNumber(int max) {
        int min = 1;

        int randomNumber = (int)(Math.random() * (max - min + 1) + min);
        return randomNumber; 
    }

    public static void main(String[] args) {
        Television tv = new Television(10);
        
        TelevisionViewer viewer = new TelevisionViewer(tv);

        viewer.startWatching(10);
    }
}
