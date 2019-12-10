package com.xiaoyaotong.api.search.serviceImpl;

import com.xiaoyaotong.api.search.dao.EsMedicineSpuDao;
import com.xiaoyaotong.api.search.entity.EsMedicineSpu;
import com.xiaoyaotong.api.search.service.EsMedicineSpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/2 8:00 PM
 */
@Service
public class EsMedicineSpuServiceImpl implements EsMedicineSpuService {

    @Autowired
    private EsMedicineSpuDao eSMedicineSpuDao;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public void addMedicineSpu(EsMedicineSpu medicineSpu) {
        eSMedicineSpuDao.save(medicineSpu);
    }
}
