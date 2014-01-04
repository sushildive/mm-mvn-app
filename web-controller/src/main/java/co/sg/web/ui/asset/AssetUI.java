package co.sg.web.ui.asset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.sg.rnd.api.asset.AssetService;

@Controller
@RequestMapping("/asset")
public class AssetUI {

	@Autowired
	private AssetService assetService;

	@RequestMapping("/list")
	public ModelAndView listAssets(ModelAndView mnv) {
		mnv.addObject("assetList", assetService.listAll());
		return mnv;
	}

}
