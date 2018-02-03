package io.github.ekardnam.sertraline.test;

import io.github.ekardnam.sertraline.builder.DefaultLayerBuilder;
import io.github.ekardnam.sertraline.builder.FeedForwardLinker;
import io.github.ekardnam.sertraline.objects.Layer;
import io.github.ekardnam.sertraline.objects.Neuron;
import org.junit.Assert;
import org.junit.Test;

public class FeedForwardLinkerTest {

    @Test
    public void testFeedForwardLinker() {
        int n1 = 1;
        int n2 = 1;
        DefaultLayerBuilder dlb = new DefaultLayerBuilder();
        Layer l1 = dlb.build(n1);
        Layer l2 = dlb.build(n2);
        FeedForwardLinker ffl = new FeedForwardLinker();
        ffl.link(l1, l2);
        for (Neuron n : l1) {
            for (Neuron nn : l2) {
                Assert.assertNotNull(n.getLinkTo(nn));
            }
        }
    }

}