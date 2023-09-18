package parallel.v3.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import parallel.v3.UserRequest;
import parallel.v3.dto.BaseDTO;
import parallel.v3.dto.UserAddressDTO;
import parallel.v3.param.AddressParam;
import parallel.v3.service.AddressService;

/**
 * @author zhaoxiaoping
 * @date 2023-9-18
 */
@Service
@RequiredArgsConstructor
public class AddressTask implements IBaseTask {

  private final AddressService addressService;

  @Override
  public String getTaskKey() {
    return "addressDTO";
  }

  @Override
  public BaseDTO<Object> execute(UserRequest req) throws InterruptedException {
    AddressParam addressParam = addressService.buildAddressParam(req);
    UserAddressDTO userAddressDTO = addressService.queryAddressInfo(addressParam);
    return new BaseDTO<>(getTaskKey(), userAddressDTO);
  }
}
