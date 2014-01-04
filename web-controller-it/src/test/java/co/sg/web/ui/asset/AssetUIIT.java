package co.sg.web.ui.asset;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.sg.model.asset.Asset;
import co.sg.rnd.api.asset.AssetService;
import co.sg.web.ui.common.AbstractIntegrationTest;

public class AssetUIIT extends AbstractIntegrationTest {

	@Autowired
	private AssetUI assetUI;
	@Autowired
	private AssetService assetService;

	@Test
	public void testListAssetsNoAssets() {
		try {
			getMockMvc().perform(get("/asset/list")).andExpect(status().isOk())
					.andExpect(view().name("asset/list"))
					.andExpect(forwardedUrl("/WEB-INF/ui/asset/list.jsp"))
					.andExpect(model().attribute("assetList", notNullValue()))
					.andExpect(model().attribute("assetList", hasSize(0)));

		} catch (Exception e) {
			e.printStackTrace();
			fail("Should not thow exception");
		}
	}

	@Test
	public void testListAssets() {
		try {
			assetService.add(new Asset());
			getMockMvc().perform(get("/asset/list")).andExpect(status().isOk())
					.andExpect(view().name("asset/list"))
					.andExpect(forwardedUrl("/WEB-INF/ui/asset/list.jsp"))
					.andExpect(model().attribute("assetList", notNullValue()))
					.andExpect(model().attribute("assetList", hasSize(1)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Should not thow exception");
		}
	}

	@Override
	protected Object[] controller() {
		return new Object[] { assetUI };
	}
}
