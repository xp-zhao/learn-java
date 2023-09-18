package parallel.v1.service;

import java.util.concurrent.TimeUnit;
import parallel.v1.dto.UserAddressDTO;
import parallel.v1.param.AddressParam;

/**
 * @author zhaoxiaoping
 * @date 2023-9-18
 */
public class AddressService {
  public UserAddressDTO queryAddressInfo(AddressParam param) throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(200);
    return new UserAddressDTO();
  }
}
