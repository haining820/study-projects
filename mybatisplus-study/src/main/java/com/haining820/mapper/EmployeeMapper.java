package com.haining820.mapper;
/**
 * Created with IntelliJ IDEA
 * Description:
 * User: hn.yu
 * Date: 2022-08-08
 * Time: 10:41
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haining820.entity.Employee;
import org.springframework.stereotype.Repository;

/**
 * @ClassName EmployeeMapper
 * @Description TODO
 */
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {

}
