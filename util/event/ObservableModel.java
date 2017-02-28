package util.event;

import java.util.ArrayList;

public abstract class ObservableModel {
    private ArrayList<IObserverModel> listeners;

    public ObservableModel() {
        this(false);
    }

    public ObservableModel(boolean change) {
        listeners = new ArrayList<IObserverModel>();
        if (change)
            triggerChange();
    }

    public void addObserverModel(IObserverModel iom) {
        this.listeners.add(iom);
    }

    public void removeObserverModel(IObserverModel iom) {
        this.listeners.remove(iom);
    }

    protected void triggerChange() {
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).modelChanged(this);
        }
    }
}
