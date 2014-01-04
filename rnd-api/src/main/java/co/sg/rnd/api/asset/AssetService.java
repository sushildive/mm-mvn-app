package co.sg.rnd.api.asset;

import java.util.Collection;

import co.sg.model.asset.Asset;

public interface AssetService {
	/**
	 * Return {@link Collection} of {@link Asset} objects.
	 * @return All {@link Asset} instances
	 */
	Collection<Asset> listAll();
	
	void add(Asset asset);
	
	void foo();
}
