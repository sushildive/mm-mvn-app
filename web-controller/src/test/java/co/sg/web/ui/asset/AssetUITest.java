package co.sg.web.ui.asset;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import co.sg.model.asset.Asset;
import co.sg.rnd.api.asset.AssetService;
import co.sg.web.ui.common.AbstractUnitTest;

public class AssetUITest extends AbstractUnitTest {

	@Autowired
	private AssetUI assetUI;
	@Autowired
	private AssetService assetService;

	@Test
	public void testListAssetsNoAssets() {
		Collection<Asset> expectedResult = new ArrayList<Asset>();
		when(assetService.listAll()).thenReturn(expectedResult);
		try {
			getMockMvc().perform(get("/asset/list")).andExpect(status().isOk())
					.andExpect(view().name("asset/list"))
					.andExpect(forwardedUrl("/WEB-INF/ui/asset/list.jsp"))
					.andExpect(model().attribute("assetList", notNullValue()))
					.andExpect(model().attribute("assetList", hasSize(0)));
			verify(assetService, times(1)).listAll();
			verifyNoMoreInteractions(assetService);

		} catch (Exception e) {
			e.printStackTrace();
			fail("Should not thow exception");
		}
	}

	@Test
	public void testListAssets() {
		Collection<Asset> expectedResult = new ArrayList<Asset>();
		expectedResult.add(new Asset());
		when(assetService.listAll()).thenReturn(expectedResult);
		try {
			getMockMvc().perform(get("/asset/list")).andExpect(status().isOk())
					.andExpect(view().name("asset/list"))
					.andExpect(forwardedUrl("/WEB-INF/ui/asset/list.jsp"))
					.andExpect(model().attribute("assetList", notNullValue()))
					.andExpect(model().attribute("assetList", hasSize(1)));
			verify(assetService, times(1)).listAll();
			verifyNoMoreInteractions(assetService);

		} catch (Exception e) {
			e.printStackTrace();
			fail("Should not thow exception");
		}
	}

	@Override
	protected Object[] controller() {
		return new Object[] { assetUI };
	}

	@Override
	protected void resetMocks() {
		Mockito.reset(assetService);
	}

}
