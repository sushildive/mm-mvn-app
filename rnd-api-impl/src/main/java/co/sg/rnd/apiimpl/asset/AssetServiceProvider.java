package co.sg.rnd.apiimpl.asset;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import co.sg.model.asset.Asset;
import co.sg.rnd.api.asset.AssetService;

@Service
public class AssetServiceProvider implements AssetService {
	private static List<Asset> assets = new ArrayList<Asset>();

	public Collection<Asset> listAll() {
		return assets;
	}

	public void add(Asset asset) {
		if (asset != null) {
			assets.add(asset);
		}
	}

	public void foo() {
		add(null);
		listAll();
	}

}
