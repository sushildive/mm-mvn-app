package co.sg.rnd.api.asset;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.sg.rnd.common.AbstractUnitTest;

public class AssetServiceProviderTest extends AbstractUnitTest {

	@Autowired
	private AssetService assetService;
	
	@Test
	public void testListAll() {
		assertNotNull(assetService.listAll());
	}

}
