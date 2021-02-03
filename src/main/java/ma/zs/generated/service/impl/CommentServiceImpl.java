package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.Comment;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.Command;
import ma.zs.generated.dao.CommentDao;
import ma.zs.generated.service.facade.CommentService;
import ma.zs.generated.service.facade.UserService;
import ma.zs.generated.service.facade.CommandService;

import ma.zs.generated.ws.rest.provided.vo.CommentVo;
import ma.zs.generated.service.util.*;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Autowired
	private UserService userService;
	@Autowired
	private CommandService commandService;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Comment> findAll() {
		return commentDao.findAll();
	}

	@Override
	public List<Comment> findByUserId(Long id) {
		return commentDao.findByUserId(id);

	}

	@Override
	@Transactional
	public int deleteByUserId(Long id) {
		return commentDao.deleteByUserId(id);

	}

	@Override
	public List<Comment> findByCommandReference(String reference) {
		return commentDao.findByCommandReference(reference);
	}

	@Override
	@Transactional
	public int deleteByCommandReference(String reference) {
		return commentDao.deleteByCommandReference(reference);
	}

	@Override
	public List<Comment> findByCommandId(Long id) {
		return commentDao.findByCommandId(id);

	}

	@Override
	@Transactional
	public int deleteByCommandId(Long id) {
		return commentDao.deleteByCommandId(id);

	}

	@Override
	public Comment findById(Long id) {
		if (id == null)
			return null;
		return commentDao.getOne(id);
	}

	@Transactional
	public void deleteById(Long id) {
		commentDao.deleteById(id);
	}

	@Override
	public Comment save(Comment comment) {

		if (comment.getUser() != null) {
			User user = userService.findById(comment.getUser().getId());

			if (user == null)
				comment.setUser(userService.save(comment.getUser()));
			else
				comment.setUser(user);
		}

		if (comment.getCommand() != null) {
			Command command = commandService.findByReference(comment.getCommand().getReference());
			if (command == null)
				comment.setCommand(commandService.save(comment.getCommand()));
			else
				comment.setCommand(command);
		}
		if (comment.getMessage() != null && !comment.getMessage().equals("")) {
			Comment savedComment = commentDao.save(comment);
			return savedComment;

		} else {
			return null;
		}
	}

	@Override
	public List<Comment> save(List<Comment> comments) {
		List<Comment> list = new ArrayList<Comment>();
		for (Comment comment : comments) {
			list.add(save(comment));
		}
		return list;
	}

	@Override
	public Comment update(Comment comment) {

		Comment foundedComment = findById(comment.getId());
		if (foundedComment == null)
			return null;

		return commentDao.save(comment);

	}

	@Override
	@Transactional
	public int delete(Comment comment) {

		if (comment.getId() == null)
			return -1;
		Comment foundedComment = findById(comment.getId());
		if (foundedComment == null)
			return -1;
		commentDao.delete(foundedComment);
		return 1;
	}

	public List<Comment> findByCriteria(CommentVo commentVo) {
		String query = "SELECT o FROM Comment o where 1=1 ";
		query += SearchUtil.addConstraintDate("o", "commentDate", "=", commentVo.getCommentDate());
		query += SearchUtil.addConstraint("o", "message", "LIKE", commentVo.getMessage());

		query += SearchUtil.addConstraint("o", "id", "=", commentVo.getId());
		query += SearchUtil.addConstraintMinMaxDate("o", "commentDate", commentVo.getCommentDateMin(),
				commentVo.getCommentDateMax());
		if (commentVo.getUserVo() != null) {
			query += SearchUtil.addConstraint("o", "user.id", "=", commentVo.getUserVo().getId());
		}

		if (commentVo.getCommandVo() != null) {
			query += SearchUtil.addConstraint("o", "command.id", "=", commentVo.getCommandVo().getId());
			query += SearchUtil.addConstraint("o", "command.reference", "LIKE",
					commentVo.getCommandVo().getReference());
		}

		return entityManager.createQuery(query).getResultList();
	}

}
