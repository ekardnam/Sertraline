package io.github.ekardnam.sertraline.data;

import com.sun.istack.internal.NotNull;
import io.github.ekardnam.sertraline.NeuralNetwork;

import java.util.concurrent.atomic.AtomicReference;

public class SynapsisDoubleAllocator extends SynapsisAllocator<Double> {

    public SynapsisDoubleAllocator(@NotNull NeuralNetwork network) {
        super(network);
    }

    public void zeroMemory() {
        for (AtomicReference<Double> d : allocated.values()) {
            d.set((double) 0);
        }
    }

}
