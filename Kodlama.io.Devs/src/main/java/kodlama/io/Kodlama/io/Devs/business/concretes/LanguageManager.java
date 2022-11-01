package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<Language> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public Language getId(int id) {
		return languageRepository.getId(id);
	}

	public void add(Language language) {
		if (!language.getName().isEmpty()) {
			for (Language language1 : languageRepository.getAll()) {
				if (language1.getName().equalsIgnoreCase(language.getName())) {
					System.out.printf("Programa dili isimleri aynı olamaz");
				}
			}
			languageRepository.add(language);
		} else {
			System.out.println("Name must not be null");
		}
	}

	@Override
	public void delete(int id) {
		languageRepository.delete(id);
	}

	@Override
	public void update(Language language) {
		if (!language.getName().equals("")) {
			languageRepository.update(language);
		} else {
			throw new RuntimeException("Name must not be null");
		}
	}

	public boolean isExist(Language language) {
		boolean control = false;
		for (Language lng : languageRepository.getAll()) {
			if (lng.getName().equals(language.getName()) || lng.getId() == language.getId()) {
				control = true;
			}
		}
		return control;
	}

}