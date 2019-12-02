package com.xiaoyaotong.api.search.serviceImpl;

import com.xiaoyaotong.api.search.dao.ESMedicineSpuDao;
import com.xiaoyaotong.api.search.entity.ESMedicineSpu;
import com.xiaoyaotong.api.search.service.ESMedicineSpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/2 8:00 PM
 */
@Service
public class ESMedicineSpuServiceImpl implements ESMedicineSpuService {

    @Autowired
    private ESMedicineSpuDao eSMedicineSpuDao;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public void addMedicineSpu(ESMedicineSpu medicineSpu) {
        eSMedicineSpuDao.save(medicineSpu);
    }
}
