import java.util.Random;


public class Television {
    private int currentChannel;
    private final int totalChannels;

    public Television(int totalChannels) {
        this.currentChannel = 1;
        this.totalChannels = totalChannels;
    }

    public int watchNextChannel() {
        int channelToWatch = currentChannel;
        currentChannel++;

        // Resetting the current channel if it exceeds the total amount of Channels
        if (currentChannel > totalChannels) {
            currentChannel = 1; 
        }
        return channelToWatch;
    }
}


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