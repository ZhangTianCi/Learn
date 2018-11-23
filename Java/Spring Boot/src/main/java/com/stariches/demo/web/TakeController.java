package com.stariches.demo.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stariches.demo.domain.Take;
import com.stariches.demo.service.TakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/Take")
public class TakeController {
	@Autowired
	private TakeService takeService;

	@GetMapping("/Index/{id}")
	public String Index(@PathVariable("id") String id, ModelMap model) {
		Take take = takeService.getById(id);
		model.put("Take", takeService.getById(id));
		return "Take/Index";
	}

	@GetMapping("/Edit/{id}")
	public String Edit(@PathVariable("id") String id, ModelMap model) {
		model.put("Take", takeService.getById(id));
		return "Take/Edit";
	}

	@ResponseBody
	@PostMapping(value = "/EditOption", consumes = "application/json")
	public Map EditOption(@RequestBody Take take) {
		try {
			int updateResult = takeService.updateAnalysisItems(take.Id, new ObjectMapper().writeValueAsString(take.AnalysisItemsObject));
			//int updateResult = takeService.updateAnalysisItems(RequestData.getId(), new ObjectMapper().writeValueAsString(RequestData.getAnalysisItems()));
			return new LinkedHashMap() {{
				put("State", true);
				put("Message", "Success");
				put("UpdateResult", updateResult);
			}};
		} catch (NullPointerException Ex) {
			Ex.printStackTrace();
			return new LinkedHashMap() {{
				put("State", false);
				put("Message", "空指针异常");
			}};
		} catch (Exception Ex) {
			Ex.printStackTrace();
			return new LinkedHashMap() {{
				put("State", false);
				put("Message", Ex.getMessage());
			}};
		}
	}

}
