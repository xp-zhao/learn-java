package parallel.v3.service;

import java.util.concurrent.TimeUnit;
import parallel.v3.UserRequest;
import parallel.v3.dto.UserAddressDTO;
import parallel.v3.param.AddressParam;

/**
 * @author zhaoxiaoping
 * @date 2023-9-18
 */
public class AddressService {

  public AddressParam buildAddressParam(UserRequest req) {
    return new AddressParam();
  }

  public UserAddressDTO queryAddressInfo(AddressParam param) throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(200);
    return new UserAddressDTO();
  }
}
