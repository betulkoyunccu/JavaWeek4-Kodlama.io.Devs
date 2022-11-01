package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

public interface LanguageService {
	List<Language> getAll();

	Language getId(int id);

	void add(Language language);

	void delete(int id);

	void update(Language language);
}
