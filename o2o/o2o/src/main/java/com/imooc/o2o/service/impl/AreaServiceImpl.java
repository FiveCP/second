package com.imooc.o2o.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.o2o.dao.AreaDao;
import com.imooc.o2o.dto.AreaExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.enums.AreaStateEnum;
import com.imooc.o2o.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	AreaDao areaDao;

	@Override
	public List<Area> queryArea() {
		return areaDao.queryArea();
	}

	@Transactional
	@Override
	public AreaExecution addArea(Area area) {
		if (area.getAreaName() != null && !area.getAreaName().equals("")) {
			area.setCreateTime(new Date());
			area.setLastEditTime(new Date());
			try {
				int i = areaDao.insert(area);
				if (i > 0)
					return new AreaExecution(AreaStateEnum.SUCCESS, area);
				else {
					return new AreaExecution(AreaStateEnum.INNER_ERROR);
				}
			} catch (Exception e) {
				throw new RuntimeException("添加区域信息失败:" + e.toString());

			}
		} else
			return new AreaExecution(AreaStateEnum.EMPTY);
	}

	@Transactional
	@Override
	public AreaExecution removeArea(long areaId) {
		if (areaId > 0) {
			try {
				int i = areaDao.deleteByPrimaryKey(areaId);
				if (i > 0)
					return new AreaExecution(AreaStateEnum.SUCCESS);
				else
					return new AreaExecution(AreaStateEnum.INNER_ERROR);
			} catch (Exception e) {
				throw new RuntimeException("删除区域信息失败:" + e.toString());

			}
		} else {
			return new AreaExecution(AreaStateEnum.EMPTY);
		}
	}

	@Transactional
	@Override
	public AreaExecution modifyArea(Area area) {
		if (area.getAreaId() != null && area.getAreaId() > 0) {
			area.setLastEditTime(new Date());
			try {
				int i = areaDao.updateByPrimaryKeySelective(area);
				if (i > 0)
					return new AreaExecution(AreaStateEnum.SUCCESS);
				else
					return new AreaExecution(AreaStateEnum.INNER_ERROR);
			} catch (Exception e) {
				throw new RuntimeException("修改区域信息失败:" + e.toString());

			}
		} else {
			return new AreaExecution(AreaStateEnum.EMPTY);
		}
	}

	@Transactional
	@Override
	public AreaExecution removeAreaList(List<Long> areaIdList) {
		if (areaIdList != null && areaIdList.size() > 0) {
			try {
				int i = areaDao.removeAreaList(areaIdList);
				if (i == areaIdList.size())
					return new AreaExecution(AreaStateEnum.SUCCESS);
				else
					return new AreaExecution(AreaStateEnum.INNER_ERROR);
			} catch (Exception e) {
				throw new RuntimeException("批量删除区域信息失败:" + e.toString());

			}
		} else {
			return new AreaExecution(AreaStateEnum.EMPTY);
		}
	}

}
