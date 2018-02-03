package io.github.ekardnam.sertraline.builder;

import io.github.ekardnam.sertraline.objects.Layer;
import io.github.ekardnam.sertraline.objects.Neuron;
import io.github.ekardnam.sertraline.objects.Synapsis;

public class FeedForwardLinker implements LayerLinker {
	
	protected RandomProvider rp;
	
	public FeedForwardLinker() {
		rp = RandomProvider.DEFAULT_PROVIDER;
	}
	
	public FeedForwardLinker(RandomProvider rp) {
		this.rp = rp;
	}

	public void link(Layer before, Layer after) {
		for (Neuron from : before) {
			for (Neuron to : after) {
				Synapsis s = new Synapsis(from, to, rp.random());
				from.getOutLinks().add(s);
				to.getInLinks().add(s);
			}
		}
	}

}