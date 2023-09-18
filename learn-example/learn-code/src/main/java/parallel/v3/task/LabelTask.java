package parallel.v3.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import parallel.v3.UserRequest;
import parallel.v3.dto.BaseDTO;
import parallel.v3.dto.UserLabelDTO;
import parallel.v3.param.LabelParam;
import parallel.v3.service.LabelService;

/**
 * @author zhaoxiaoping
 * @date 2023-9-18
 */
@Service
@RequiredArgsConstructor
public class LabelTask implements IBaseTask {

  private final LabelService labelService;

  @Override
  public String getTaskKey() {
    return "labelDTO";
  }

  @Override
  public BaseDTO<Object> execute(UserRequest req) throws InterruptedException {
    LabelParam labelParam = labelService.buildLabelParam(req);
    UserLabelDTO userLabelDTO = labelService.queryLabelInfo(labelParam);
    return new BaseDTO<>(getTaskKey(), userLabelDTO);
  }
}
