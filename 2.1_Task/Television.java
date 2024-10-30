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